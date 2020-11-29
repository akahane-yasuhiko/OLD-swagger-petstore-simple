package io.swagger.api;

import io.swagger.model.Pet;

public interface ResponseConverter {
	public Pet convert(Object o);
}
