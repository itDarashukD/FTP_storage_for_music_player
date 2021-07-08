package com.music_player.storage;


import com.example.music_player.entity.Source;
import com.example.music_player.storage.IStorageSourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Configuration
@ComponentScan
public class FTPStorage implements IStorageSourceService {

    @PostConstruct
    public void postConstruct(){
        log.info("Storage the UserStorage was created...");
    }

    @Override
    public List<Source> save(InputStream inputStream, String filename, String contentType) {
        log.info("save() in FTPStorage ");
        return List.of(new Source(1111L
                ,1L
                ,1L
                ,"name1"
                ,"/1/1"
                ,1111L
                ,"111111"
                ,"FTP_STORAGE"
                ,"mp3"));
    }

    @Override
    public void delete(Source source) {
        log.info("delete source in UserStorage");
    }

    @Override
    public boolean isExist(Source source) {
        log.info("isExist source in FTPStorage");
        return false;
    }

    @Override
    public InputStream findSongBySource(Source source) throws IOException {
        log.info("findSongBySource() source in FTPStorage");
        return getInputstreamToGagFindSongBySourceMethod();
    }

    private InputStream getInputstreamToGagFindSongBySourceMethod() {
        InputStream inputStream = null;
        try {
            File targetStream = File.createTempFile("temporary-Inputstream", ".tmp");
            inputStream = FileUtils.openInputStream(targetStream);
        } catch (IOException e) {
            log.error("Exception IN : putInputStreamToFile()" + e.getMessage());
        }
        return inputStream;
    }

    @Override
    public String getTypeStorage() {
        log.info("getTypeStorage() source in FTPStorage");
        return "FTP_STORAGE";
    }
}
