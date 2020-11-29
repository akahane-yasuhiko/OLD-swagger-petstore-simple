package io.swagger.api;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.swagger.model.Pet;

@Component
public class DefaultResponseConverter implements ResponseConverter {
	final String PRE_FIX=Pet.class.getName();

	Map<String, String> map = new HashMap<String, String>();

	public DefaultResponseConverter() {
		map.put("1", "Dog");
		map.put("2", "Cat");
	}

	@Override
	public Pet convert(Object in) {
		Pet pet;

		String clazz = (PRE_FIX + map.get((String)in)).replaceAll("null", "");

		try {
			pet = (Pet)Class.forName(clazz).getDeclaredConstructor().newInstance();
			return pet;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
