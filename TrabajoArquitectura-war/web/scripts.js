$('h2').on('click',function(){
    $(this).next().slideToggle();
});

$('h4').on('click',function(){
    $(this).next().slideToggle();
    $('#textoHora').load(location.href + " #textoHora");
});

$('#cambiarFotoBoton').on('click',function(){
   $('#cambiarFoto').slideToggle(); 
});

function validateCVForm(){
    if(document.forms["cvForm"]["firstname"].value.length>100){
        alert("El nombre no puede exceder las 100 letras");
        return false;
    }
    
    if(document.forms["cvForm"]["lastname"].value.length>200){
        alert("Los apellidos no pueden exceder las 200 letras");
        return false;
    }
    
    if(document.forms["cvForm"]["provincia"].value.length>100){
        alert("El nombre de la provincia no puede exceder las 100 letras");
        return false;
    }
    
    if(document.forms["cvForm"]["exlab"].value.length>2000){
        alert("Los campos de experiencia, educación o competencias no pueden \n\
        exceder las 2000 letras (Error: Campo de experiencia laboral)");
        return false;
    }
    
    if(document.forms["cvForm"]["edyfor"].value.length>2000){
        alert("Los campos de experiencia, educación o competencias no pueden \n\
        exceder las 2000 letras (Error: Campo de educación y formación)");
        return false;
    }
    
    if(document.forms["cvForm"]["comcom"].value.length>2000){
        alert("Los campos de experiencia, educación o competencias no pueden \n\
        exceder las 2000 letras (Error: Campo de competencias comunicativas)");
        return false;
    }
    
    if(document.forms["cvForm"]["comorg"].value.length>2000){
        alert("Los campos de experiencia, educación o competencias no pueden \n\
        exceder las 2000 letras (Error: Campo de competencias organizativas)");
        return false;
    }
    
    if(document.forms["cvForm"]["comemp"].value.length>2000){
        alert("Los campos de experiencia, educación o competencias no pueden \n\
        exceder las 2000 letras (Error: Campo de competencias de empleo)");
        return false;
    }
    
    if(document.forms["cvForm"]["comdig"].value.length>2000){
        alert("Los campos de experiencia, educación o competencias no pueden \n\
        exceder las 2000 letras (Error: Campo de competencias digitales)");
        return false;
    }
    
    if(document.forms["cvForm"]["lengmat"].value.length>50){
        alert("El campo de lengua materna no puede superar las 50 letras");
        return false;
    }
    
    if(document.forms["cvForm"]["idiomas"].value.length>50){
        alert("El campo de idiomas no puede superar las 100 letras");
        return false;
    }
    
    return true;
}

function validateEnterprisePerfil(){
    if(document.forms["enterprisePerfilForm"]["perfil"].value.length>1000){
        alert("El campo Perfil no puede exceder las 1000 letras");
        return false;
    }
    if(document.forms["enterprisePerfilForm"]["objetivo"].value.length>1000){
        alert("El campo Objetivo no puede exceder las 1000 letras");
        return false;
    }
    if(document.forms["enterprisePerfilForm"]["mision"].value.length>1000){
        alert("El campo Misión no puede exceder las 1000 letras");
        return false;
    }
    if(document.forms["enterprisePerfilForm"]["vision"].value.length>1000){
        alert("El campo Visión no puede exceder las 1000 letras");
        return false;
    }
    if(document.forms["enterprisePerfilForm"]["valores"].value.length>1000){
        alert("El campo Valores no puede exceder las 1000 letras");
        return false;
    }
    
    if(document.forms["enterprisePerfilForm"]["perfil"].value.length===0){
        document.forms["enterprisePerfilForm"]["perfil"].value = "Nuestro perfil";
    }
    if(document.forms["enterprisePerfilForm"]["objetivo"].value.length===0){
        document.forms["enterprisePerfilForm"]["objetivo"].value = "Nuestro objetivo";
    }
    if(document.forms["enterprisePerfilForm"]["mision"].value.length===0){
        document.forms["enterprisePerfilForm"]["mision"].value = "Nuestra mision";
    }
    if(document.forms["enterprisePerfilForm"]["vision"].value.length===0){
        document.forms["enterprisePerfilForm"]["vision"].value = "Nuestra vision";
    }
    if(document.forms["enterprisePerfilForm"]["valores"].value.length===0){
        document.forms["enterprisePerfilForm"]["valores"].value = "Nuestros valores";
    }
    
    return true; 
}

function validarOfertas(){
    if((document.forms["ofertasForm"]["cargo"].value.length>50)||((document.forms["ofertasForm"]["cargo"].value.length===0))){
        alert("El campo Cargo debe contener entre 1 y 50 letras");
        return false;
    }
    if(document.forms["ofertasForm"]["descripcion"].value.length>2000){
        alert("El campo Descripcion no puede exceder las 2000 letras");
        return false;
    }
    return true;
}