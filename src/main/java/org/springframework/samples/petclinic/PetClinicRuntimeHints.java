package org.springframework.samples.petclinic;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

public class PetClinicRuntimeHints implements RuntimeHintsRegistrar {

	@Override
	public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
		hints.resources().registerPattern("db/*");
		hints.resources().registerPattern("db/*/*");
		hints.resources().registerPattern("messages/*");
		hints.resources().registerPattern("mysql-default-conf");
		hints.reflection().registerType(BaseEntity.class, typeHint -> typeHint.withJavaSerialization(true));
		hints.reflection().registerType(Person.class, typeHint -> typeHint.withJavaSerialization(true));
		hints.reflection().registerType(Vet.class, typeHint -> typeHint.withJavaSerialization(true));
	}

}
