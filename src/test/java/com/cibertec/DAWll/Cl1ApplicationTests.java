package com.cibertec.DAWll;

import com.cibertec.DAWll.service.AlumnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Cl1ApplicationTests {

	@Autowired
	public AlumnoService serv;
	@Test
	void contextLoads() {
		System.out.println(serv.maxCodigoAlumno());
	}

}
