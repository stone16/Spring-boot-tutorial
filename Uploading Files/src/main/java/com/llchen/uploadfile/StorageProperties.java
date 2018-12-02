package com.llchen.uploadfile;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Generate own configuration metadata file form items annotated with @ConfigurationProperties
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
