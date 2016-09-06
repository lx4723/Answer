// Copyright (c) 2003-2013, LogMeIn, Inc. All rights reserved.
// This is part of Xively4J library, it is under the BSD 3-Clause license.
package com.answer.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for parsing to and from json for API calls
 * json转换工具
 * @author s0pau
 */
public class JsonUtil
{

	private static ObjectMapper objectMapper;

	/**
	 * 将对象转换为json
	 */
	public static String toJson(Object model)
	{
		String json = null;

		try
		{
			// ADD ROOT
			// Setting SerializationConfig.Feature.WRAP_ROOT_VALUE at mapper
			// did not read annotated label properly, use withRootName
			json = getObjectMapper().writeValueAsString(model);
			// ApiKey needs to be wrapped in a root node without the array
			// container, hack the standards!
		} catch (IOException e)
		{

			e.printStackTrace();
		}

		return json;
	}

	/**
	 * 将json格式转换为数组对�?
	 * @param body
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> List<T> toConnectedObjects(String body, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException
	{

		List<T> objs = null;
		CollectionType collectionType = TypeFactory.defaultInstance()
				.constructCollectionType(ArrayList.class, clazz);
		try
		{
			objs = getObjectMapper().readValue(body, collectionType);
		} catch (IOException e)
		{

			e.printStackTrace();
		}

		return objs;
	}

	/**
	 * 将json转换为对�?
	 * @param body
	 * @param clazz
	 * @return
	 */
	public static <T> T toConnectedObject(String body, Class<T> clazz)
	{

		T obj = null;

		try
		{
			obj = (T) getObjectMapper().readValue(body, clazz);
		} catch (IOException e)
		{

			e.printStackTrace();
		}

		return obj;
	}

	public static ObjectMapper getObjectMapper()
	{
		if (objectMapper == null)
		{
			ObjectMapper retval = new ObjectMapper();
			retval.configure(
					DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			retval.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			retval.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,
					false);
			retval.configure(DeserializationFeature.EAGER_DESERIALIZER_FETCH,
					false);
			retval.configure(SerializationFeature.EAGER_SERIALIZER_FETCH, false);
			objectMapper = retval;
		}
		return objectMapper;
	}

	/**
	 * 判断第一个字母是否为{或[
	 * 判断字符串是JSONObject还是JSONArray
	 * 返回true为JSONObject，false为JSONArray
	 * @param json
	 * @return
	 */
	public static boolean getJSONType(String json){
		if (json == null || json.substring(0, 1).toCharArray()[0] == '{') {
			return true;
		} else {
			return false;
		}
	}
}
