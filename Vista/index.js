function loadTable() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/v1/skills");
    
    xhttp.send();
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        console.log(this.responseText);
        var trHTML = ''; 
        const objects = JSON.parse(this.responseText);
        for (let object of objects) {
          trHTML += '<td>'+object['id']+'</td>';
          trHTML += '<td>'+object['nombre']+'</td>';
          trHTML += '<td>'+object['tipo']+'</td>';
          trHTML += '<td>'+object['dificultad']+'</td>';
          trHTML += '<td><button type="button" class="btn btn-outline-secondary" onclick="showUserEditBox('+object['id']+')">Edit</button>';
          trHTML += '<button type="button" class="btn btn-outline-danger" onclick="userDelete('+object['id']+')">Del</button></td>';
          trHTML += "</tr>";
        }
        document.getElementById("mytable").innerHTML = trHTML;
      }
    };
  }
  
  loadTable();


  function showUserCreateBox() {
    Swal.fire({
      title: 'Create user',
      html:
        '<input id="id" type="hidden">' +
        '<input id="nombre" class="swal2-input" placeholder="JEFE">' +
        '<input id="tipo" class="swal2-input" placeholder="TIPO">' +
        '<input id="dificultad" class="swal2-input" placeholder="DIFICULTAD">',
      focusConfirm: false,
      preConfirm: () => {
        userCreate();
      }
    })
  }
  
  function userCreate() {
    const dificultad = document.getElementById("dificultad").value;
    const nombre = document.getElementById("nombre").value;
    const tipo = document.getElementById("tipo").value;

      
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/v1/skills");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify({ 
       "nombre": nombre, "tipo": tipo, "dificultad": dificultad,
  
    }));
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        const objects = JSON.parse(this.responseText);
        Swal.fire(objects['message']);
        loadTable();
      }
    };
  }