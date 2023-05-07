$(document).on("click","#btnAgregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#cboespecialidad").empty();
    $("#txtproce").val("");
    $("#hddidalumno").val("");
    $.ajax({
        type: "GET",
        url: "/listarEspecialidades",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idEsp}">${value.nomEspecialidad}</option>`
                )
            })
        }
    })
    $("#modalShow").modal("show");
  })

$(document).on("click","#btnActualizar", function(){
    $("#txtnombre").val($(this).attr("data-nombre"));
    $("#txtapellido").val($(this).attr("data-apellido"));
    $("#cboespecialidad").empty();
    $("#txtproce").val($(this).attr("data-proce"));
    $("#hddidalumno").val($(this).attr("data-idAlumno"));
    var idespecialidad = $(this).attr("data-IdEsp");
    $.ajax({
        type: "GET",
        url: "/listarEspecialidades",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idEsp}">${value.nomEspecialidad}</option>`
                )
            })
            $("#cboespecialidad").val(idespecialidad);
        }
    })
    $("#modalShow").modal("show");
  })

$(document).on("click", "#btnEliminar", function(){
    var idalumno = $(this).attr("data-idAlumno");

    $.ajax({
        type: "DELETE",
        url: "/eliminarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: idalumno
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlumnos();
            }
            alert(resultado.mensaje);
        }
    });
});

$(document).on("click", "#btnGuardar", function(){
    $.ajax({
        type: "POST",
        url: "/registrarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: $("#hddidalumno").val(),
            nombre: $("#txtnombre").val(),
            apellido: $("#txtapellido").val(),
            idEsp: $("#cboespecialidad").val(),
            proce: $("#txtproce").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlumnos();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalShow").modal("hide");
});

function listarAlumnos(){
    $.ajax({
        type: "GET",
        url: "/listarAlumnos",
        dataType: "json",
        success: function(resultado){
            $("#tblAlumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblAlumno > tbody").append("<tr>"+
                    "<th scope='row'>"+value.idAlumno+"</th>"+
                    "<th scope='row'>"+value.nombre+"</th>"+
                    "<th scope='row'>"+value.apellido+"</th>"+
                    "<th scope='row'>"+value.especialidad.nomEspecialidad+"</th>"+
                    "<th scope='row'>"+value.proce+"</th>"+
                    "<th scope='row'>"+
                        "<button id='btnActualizar' type='button' class='btn btn-info'"+
                                     "data-idAlumno='"+value.idAlumno+"'"+
                                     "data-nombre='"+value.nombre+"'"+
                                     "data-apellido='"+value.apellido+"'"+
                                     "data-IdEsp='"+value.especialidad.idEsp+"'"+
                                     "data-proce='"+value.proce+"'>Actualizar</button>"+
                    "</th>"+
                    "<th scope='row'>"+
                        "<button id='btnEliminar' type='button' class='btn btn-danger'"+
                                     "data-idAlumno='"+value.idAlumno+"'"+
                                     "data-nombre='"+value.nombre+"'"+
                                     "data-apellido='"+value.apellido+"'>Eliminar</button>"+
                    "</th></tr>");
            })
        }
    })
}