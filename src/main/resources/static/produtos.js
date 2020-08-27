// Adiciona id nas linhas automaticamente ao carregar

function idLinhas(){

    var linhas = document.getElementsByClassName("linha");

    for(var i = 0; i < linhas.length; i++){
        linhas[i].setAttribute('id', i);
    }

}

function selecionar(id){

    var linhas = document.getElementsByClassName("linha");

    var id2 = linhas[id].children[0].innerHTML;
    var nome = linhas[id].children[1].children[0].innerHTML;
    var quantidade = linhas[id].children[2].innerHTML;
    var precoCompra = linhas[id].children[3].innerHTML;
    var precoRevenda = linhas[id].children[4].innerHTML;
    var tipo = linhas[id].children[5].innerHTML

    atribuiValue(nome, quantidade, precoCompra, precoRevenda, id2, tipo);

        }

function lucro(precoCompra, precoRevenda, quantidade){
    precoLiquido = precoRevenda - precoCompra;
    precoLiquido = precoLiquido * quantidade;

    return precoLiquido;
}

function atribuiValue(nome, quantidade, precoCompra, precoRevenda, id, tipo){
     document.getElementById("recebeNome").value= nome;
     document.getElementById("recebeQnt").value= quantidade;
     document.getElementById("precoCompra").value= precoCompra;
     document.getElementById("precoRevenda").value= precoRevenda;
     document.getElementById("recebeID").value= id;
     document.getElementById("recebeTipo").value= tipo;


     liquido = parseFloat(lucro(precoCompra, precoRevenda, quantidade).toFixed(2));
     document.getElementById("recebeLucro").value= liquido;

}
