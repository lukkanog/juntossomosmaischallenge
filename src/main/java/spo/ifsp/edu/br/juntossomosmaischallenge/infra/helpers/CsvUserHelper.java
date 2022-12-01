package spo.ifsp.edu.br.juntossomosmaischallenge.infra.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.builders.UserBuilder;

public class CsvUserHelper {
    public static List<User> getUsersFromCsv(String csv) throws Exception {
        //csv: gender,name.title,name.first,name.last,location.street,location.city,location.state,location.postcode,location.coordinates.latitude,location.coordinates.longitude,location.timezone.offset,location.timezone.description,email,dob.date,dob.age,registered.date,registered.age,phone,cell,picture.large,picture.medium,picture.thumbnail

        List<String> lines = new ArrayList<>(Arrays.asList(csv.split("\r")));

        lines = getValidCsvLines(lines);

        List<User> users = new ArrayList<>();

        for (String line : lines) {

            String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            
            for (int i = 0; i < fields.length - 1; i++)
                fields[i] = removeQuotesAndNewLineFromString(fields[i]);

            User user = new UserBuilder()
                    .withGender(fields[0].charAt(0))
                    .withName(fields[1], fields[2], fields[3])
                    .withLocation(fields[4], fields[5], fields[6], fields[7], fields[8], fields[9])
                    .withTimezone(fields[10], fields[11])
                    .withEmail(fields[12])
                    .withBirthday(getDateFromString(fields[13]))
                    .withRegistered(getDateFromString(fields[15]))
                    .withTelephoneNumbers(fields[17].split(";"))
                    .withMobilePhoneNumbers(fields[18].split(";"))
                    .withPicture(fields[19], fields[20], fields[21])
                    .withNationality("BR")
                    .build();

            users.add(user);
        }

        return users;
    }

    private static List<String> getValidCsvLines(List<String> csvLines) {
        csvLines.remove(0);
        List<String> lines = getCsvLinesWithoutEmptyLines(csvLines);

        return lines;
    }

    private static List<String> getCsvLinesWithoutEmptyLines(List<String> csvLines) {
        Predicate<String> notAnEmptyLine = line -> line != null && !(line.trim().isEmpty() || line.trim().equals("\n"));
        List<String> notEmptyCsvLines = csvLines.stream().filter(notAnEmptyLine).collect(Collectors.toList());

        return notEmptyCsvLines;
    }

    private static String removeQuotesAndNewLineFromString(String field) {
        return field.replace("\"", "").replace("\n", "");
    }

    private static Date getDateFromString(String date) throws Exception {
        date = date.replaceAll("T", " ").replaceAll("Z", "");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
    }
}
