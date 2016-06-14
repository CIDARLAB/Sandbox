/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.get;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.io.InputStream;
import static org.cidarlab.dom.BadgeEndPoints.SEP;
import static org.cidarlab.dom.BadgeEndPoints.SITE;

/**
 *
 * @author Alex
 */
public class Files {
    /**
     * get file from PCR hero site directory
     * @param extension the extension from the root directory where the file is located
     * @return InputStream of the file
     * @throws com.mashape.unirest.http.exceptions.UnirestException
     * @throws java.io.IOException
     */
    public static InputStream get(String extension) throws UnirestException, IOException {
        HttpResponse<InputStream> response = Unirest.get(SITE + SEP + extension)
                .header("content-type", "*/*")
                .asBinary();

        return response.getBody();
    }

}
