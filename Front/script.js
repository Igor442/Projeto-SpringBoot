function abrirPopup(id){
    document.getElementById(id).style.display = "flex";
}

function fecharPopup(id){
    document.getElementById(id).style.display = "none";
}
let produtosGlobal = [];

async function carregarProdutos() {

    try {

        const resposta = await fetch("http://127.0.0.1:8080/lista");

        produtosGlobal = await resposta.json();
        
        document.getElementById("pesquisa").value = "";

        exibirProdutos(produtosGlobal);

    } catch (erro) {

        console.log("Erro ao buscar produtos:", erro);

    }
}

function exibirProdutos(produtos) {
    const tbody = document.getElementById("produtos");
    tbody.innerHTML = "";
    
    produtos.forEach(produto => {
        tbody.innerHTML += `
            <tr>
                <td>${produto.id}</td>
                <td>${produto.nomeProduto}</td>
                <td>R$ ${produto.preco}</td>
                <td>${produto.quantidade || '-'}</td>
                <td>${produto.tipo || '-'}</td>
                <td><button class="btn-action-edit" onclick="preencherEdicao(${produto.id}, '${produto.nomeProduto}', ${produto.preco}, ${produto.quantidade}, '${produto.tipo}')">Editar</button></td>
            </tr>
        `;
    });
}

function preencherEdicao(id, nome, preco, quantidade, tipo) {
    document.getElementById("idedit").value = id;
    document.getElementById("nomeedit").value = nome;
    document.getElementById("precoedit").value = preco;
    document.getElementById("quantidadeedit").value = quantidade;
    document.getElementById("tipoedit").value = tipo;
    abrirPopup('popupEdit');
}

function filtrarProdutos() {
    const pesquisa = document.getElementById("pesquisa").value.toLowerCase();
    const produtosFiltrados = produtosGlobal.filter(produto => 
        produto.nomeProduto.toLowerCase().includes(pesquisa)
    );
    exibirProdutos(produtosFiltrados);
}

carregarProdutos();

async function enviardados() {

    const nome = document.getElementById("nomead").value;
    const preco = document.getElementById("precoad").value;
    const quantidade = document.getElementById("quantidadead").value;
    const tipo = document.getElementById("tipoad").value;

    const produto = {
        nomeProduto: nome,
        preco: parseFloat(preco),
        quantidade: parseInt(quantidade),
        tipo: tipo
    };

    try {
    const resposta = await fetch("http://127.0.0.1:8080/lista", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(produto)
    });

      if (resposta.ok) {

            alert("Produto adicionado com sucesso!");
            fecharPopup("popupAdd");
            carregarProdutos();
        } else {
            alert("Erro ao adicionar produto");
        }

    } catch (erro) {
        console.error("Erro ao enviar dados:", erro);
    }
}
async function enviardadosdelete() {

    const id = document.getElementById("iddelete").value;
    const produto = {
        id: parseInt(id)
    };

    try {

        const resposta = await fetch(`http://localhost:8080/lista/${id}`, {
            method: "DELETE"
        });

        if (resposta.ok) {
            alert("Produto deletado com sucesso!");
            carregarProdutos();
            fecharPopup("popupDelete");

        } else {
            alert("Erro ao deletar produto");
        }

    } catch (erro) {

        console.error("Erro:", erro);

    }
}

async function enviardadosedit() {

    const id = document.getElementById("idedit").value;
    const nome = document.getElementById("nomeedit").value;
    const preco = document.getElementById("precoedit").value;
    const quantidade = document.getElementById("quantidadeedit").value;
    const tipo = document.getElementById("tipoedit").value;

    const produto = {
        id: parseInt(id),
        nomeProduto: nome,
        preco: parseFloat(preco),
        quantidade: parseInt(quantidade),
        tipo: tipo
    };

    try {
        const resposta = await fetch(`http://localhost:8080/lista/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(produto)
        });

        if (resposta.ok) {
            alert("Produto editado com sucesso!");
            fecharPopup("popupEdit");
            carregarProdutos();
        } else {
            alert("Erro ao editar produto");
        }

    } catch (erro) {
        console.error("Erro ao enviar dados:", erro);
    }
}
