package com.grgbanking.electric.transcoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.grgbanking.electric.util.CloseUtil;

public class ObjectsTranscoder<T> {

	public byte[] serialize(List<T> value) {
		if (value == null) {
			throw new NullPointerException("Can't serialize null");
		}
		byte[] rv = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			for (T t : value) {
				os.writeObject(t);
			}
			os.writeObject(null);
			os.close();
			bos.close();
			rv = bos.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Non-serializable object", e);
		} finally {
			CloseUtil.close(os);
			CloseUtil.close(bos);
		}
		return rv;
	}

	@SuppressWarnings("unchecked")
	public List<T> deserialize(byte[] in) {
		List<T> list = new ArrayList<T>();
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (in != null) {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				while (true) {
					T t = (T) is.readObject();
					if (t == null) {
						break;
					} else {
						list.add(t);
					}
				}
				is.close();
				bis.close();
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {
			CloseUtil.close(is);
			CloseUtil.close(bis);
		}
		return list;
	}
}
