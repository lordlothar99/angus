package com.lothar.angus;

import java.io.IOException;

import org.json.simple.JSONObject;

import ai.angus.sdk.Configuration;
import ai.angus.sdk.Job;
import ai.angus.sdk.ProcessException;
import ai.angus.sdk.Root;
import ai.angus.sdk.Service;
import ai.angus.sdk.impl.ConfigurationImpl;
import ai.angus.sdk.impl.File;

/**
 * http://angus-doc.readthedocs.io/en/latest/getting-started/java.html
 */
public class FaceDetect {
    public static void main(String[] args) throws IOException, ProcessException {
        Configuration conf = new ConfigurationImpl();

        Root root = conf.connect();
        Service service = root.getServices().getService("age_and_gender_estimation", 1);

        JSONObject params = new JSONObject();
        params.put("image", new File("src/main/resources/francois.jpg"));

        Job job = service.process(params);

        System.out.println(job.getResult().toJSONString());
    }
}
