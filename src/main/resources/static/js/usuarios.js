$(document).ready.(function(){
    mostrarUsuarios();

    $('#usuarios').DataTable();
});

async function mostrarUsuarios(){
    const request = await fetch('usuarios',{
        method 'POST'
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
    }
    });

    const usuarios = await request.json();

    console.log(content);
}