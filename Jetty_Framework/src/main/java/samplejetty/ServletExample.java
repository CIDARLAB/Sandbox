/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejetty;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author prash
 */
public class ServletExample extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        PrintWriter writer = response.getWriter();

        System.out.println("RANK ::"+request.getParameter("rank"));
        int rank = Integer.parseInt(request.getParameter("rank"));
        
        rank++;
        

        JSONObject result = new JSONObject();
        result.put("rank",rank);
        //return response
        writer.println(result);
        writer.flush();
        writer.close();
    }
}
