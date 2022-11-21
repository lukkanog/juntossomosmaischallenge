package spo.ifsp.edu.br.juntossomosmaischallenge.infra.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="uri")
public class UriConfiguration {
    private String csvUri;
    private String jsonUri;

    public String getCsvUri() {
        return csvUri;
    }

    public String getJsonUri() {
        return jsonUri;
    }

    public void setCsvUri(String csvUri) {
        this.csvUri = csvUri;
    }

    public void setJsonUri(String jsonUri) {
        this.jsonUri = jsonUri;
    }
}
