package com.example.onedriveapp.service.impl;

import com.example.onedriveapp.auth.AuthenticationProvider;
import com.example.onedriveapp.service.OneDriveService;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.options.Option;
import com.microsoft.graph.options.QueryOption;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.LinkedList;

@Slf4j
@Service
@RequiredArgsConstructor
public class OneDriveServiceImpl implements OneDriveService {

    //TODO: exceptionHandler and retry
    @SneakyThrows
    public byte[] getOneDriveFile(String name) {
        final IGraphServiceClient graphClient = new AuthenticationProvider().getAuthProvider();
        LinkedList<Option> requestOptions = addRequestOptions(name);

        InputStream stream = graphClient.customRequest("/me/drive/root", InputStream.class).buildRequest(requestOptions).get();
        log.info("File content successfully download");
        return IOUtils.toByteArray(stream);
    }

    private LinkedList<Option> addRequestOptions(String name) {
        LinkedList<Option> requestOptions = new LinkedList<Option>();
        if (!name.isEmpty()) {
            requestOptions.add(new QueryOption("name", name));
        }
        return requestOptions;
    }
}
