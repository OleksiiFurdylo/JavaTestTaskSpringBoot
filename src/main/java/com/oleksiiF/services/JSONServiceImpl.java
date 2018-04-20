package com.oleksiiF.services;

import com.oleksiiF.dao.DataDaoImpl;
import com.oleksiiF.model.Data;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;

/**
 * Created by OleksiiF on 19.04.2018.
 */
@Service
public class JSONServiceImpl implements JSONService{

    OkHttpClient client = new OkHttpClient();
    Data data;

    @Autowired
    DataDaoImpl dataDaoImpl;

    public Data getJSONObjects(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Data.class);

            JSONObject jo = new JSONObject(response.body().string());

            Configuration config = new Configuration();
            MappedNamespaceConvention con = new MappedNamespaceConvention(config);
            XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(jo, con);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            data = (Data) unmarshaller.unmarshal(xmlStreamReader);


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return data;
    }


    public String sendToDb(Data data){
            return dataDaoImpl.putToDB(data);
    }
}
