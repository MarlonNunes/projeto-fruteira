//Seleciona a linha selecionada e adiciona no campo do "cliente escolhido"

function selecionar(id){
    
    var linhas = document.getElementsByClassName("linha");

    var nome = linhas[id].children[1].children[0].innerHTML;
    var id2 = linhas[id].children[0].children[0].children[0].innerHTML;
    var divida = linhas[id].children[4].children[0].children[0].innerHTML;

    atribuiValue(nome, id2, divida);

    mostrarBotoes();


}


// Adiciona id nas linhas automaticamente ao carregar

function idLinhas(){
    
    var linhas = document.getElementsByClassName("linha");
    
    for(var i = 0; i < linhas.length; i++){
        linhas[i].setAttribute('id', i);
    }

}

function atribuiValue(nome, id, divida){
     document.getElementById("recebeNome").value= nome;
     document.getElementById("recebeID").value= id;
     document.getElementById("recebeID2").value= id;
     document.getElementById("recebeDivida").innerHTML= divida;

}

function mostrarBotoes(){
    var divs = document.getElementsByClassName("botao");

          divs[0].style.display = "block";
          divs[1].style.display = "block";
}