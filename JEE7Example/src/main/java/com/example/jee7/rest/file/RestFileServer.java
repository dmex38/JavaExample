package com.example.jee7.rest.file;

import java.io.File;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Path("downloadfile")
public class RestFileServer {

    @GET
    @Path("/{FILENAME}/{FILE_ID}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@PathParam("FILENAME") final String filename, @PathParam("FILE_ID") final Integer fileId) {
        // fetch the file to download from file system or database, or wherever...
        File file = getFileToDownload(filename);
        if (file == null || !file.exists()) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return Response.ok(file).header("Content-Disposition", "attachment; filename=" + file.getName()).build();
    }

    private File getFileToDownload(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response handleUpload(InputStream stream) throws Exception {
        return Response.ok().build();
    }

}
