package com.cibertec.DAWll.controller;

import com.cibertec.DAWll.model.Alumno;
import com.cibertec.DAWll.model.Especialidad;
import com.cibertec.DAWll.model.request.AlumnoRequest;
import com.cibertec.DAWll.model.response.ResultadoResponse;
import com.cibertec.DAWll.service.AlumnoService;
import com.cibertec.DAWll.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("listaAlumnos",alumnoService.listarAlumnos());
        return "CL1";
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }

    @GetMapping("/listarEspecialidades")
    @ResponseBody
    public List<Especialidad> listaEspecialidad(){
        return especialidadService.listarEspecialidades();
    }

    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje;
        Boolean respuesta = true;

        try{
            Alumno objAlumno = new Alumno();
            if(alumnoRequest.getIdalumno() == ""){
                mensaje="Alumno registrado correctamente!";
                int maxCode = Integer.parseInt(alumnoService.maxCodigoAlumno())+1;
                String newIdAlumno = String.format("A%04d", maxCode);
                objAlumno.setIdAlumno(newIdAlumno);
            }
            else{
                mensaje="Alumno actualizado correctamente!";
                objAlumno.setIdAlumno(alumnoRequest.getIdalumno());
            }
            objAlumno.setNombre(alumnoRequest.getNombre());
            objAlumno.setApellido(alumnoRequest.getApellido());
            objAlumno.setProce(alumnoRequest.getProce());
            Especialidad objEspecialidad = new Especialidad();
            objEspecialidad.setIdEsp(alumnoRequest.getIdEsp());
            objAlumno.setEspecialidad(objEspecialidad);

            alumnoService.registrarAlumno(objAlumno);
        } catch (Exception ex){
            mensaje = "Alumno no registrado!";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje="Alumno eliminado correctamente!";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(alumnoRequest.getIdalumno());
        }catch (Exception ex){
            mensaje = "Alumno no eliminado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
