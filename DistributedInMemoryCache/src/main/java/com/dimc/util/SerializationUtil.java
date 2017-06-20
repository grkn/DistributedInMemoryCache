package com.dimc.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.dimc.collections.interfaces.SMap;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class SerializationUtil {

	
	private final static Kryo kyro = new Kryo();
	
	public static byte[] serializeWithKyro(SMap modal){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Output output = new Output(bos);
	    SerializationUtil.kyro.writeObject(output, modal);
	    output.close();
	    try {
			bos.close();
		} catch (IOException e) {
		}
	    return bos.toByteArray();
	}
	
	public static SMap deserializeWithKyro(byte[] arr){
		ByteArrayInputStream bis = new ByteArrayInputStream(arr);
		Input input = new Input(bis);
	    SMap obj = SerializationUtil.kyro.readObject(input, SMap.class);
	    input.close();
	    try {
			bis.close();
		} catch (IOException e) {
		}
	    return obj;
	}
	
	
	public static byte[] serialize(SMap modal) throws IOException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		byte[] result;
		try {
		  out = new ObjectOutputStream(bos);   
		  out.writeObject(modal);
		  out.flush();
		  result = bos.toByteArray();
		} finally {
		  try {
		    bos.close();
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		}
		return result;
	}
	
	public static SMap deserialize(byte[] arr) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(arr);
		ObjectInput in = null;
		SMap object = null;
		try {
		  in = new ObjectInputStream(bis);
		  object = (SMap) in.readObject(); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		  try {
		    if (in != null) {
		      in.close();
		    }
		  } catch (IOException ex) {
		    // ignore close exception
		  }
		}
		
		return object;
	}
	
	
}
