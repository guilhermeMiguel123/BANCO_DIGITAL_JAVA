const form = document.getElementById("accountForm");
const listButton = document.getElementById("listAccounts");
const accountList = document.getElementById("accountList");

// Chamadas HTTP para o backend banco

const baseURL = "http://localhost:8080/api/contas";

const listarContas = async () => {
  try {
    const response = await fetch(baseURL, {
      method: "GET"
    });

    if(!response.ok) {
      throw new Error(`Erro na requisição: ${response.statusText}`);
    }

    const contas = await response.json();

    accountList.innerHTML = "";

    if(contas.length == 0) {
      accountList.innerHTML = "<p>Nenhuma conta encontrada.</p>";
      return;
    }

    contas.forEach(conta => {
      const contaElement = document.createElement("div");
      contaElement.classList.add("p-2", "rounded-lg", "bg-neutral-700", "mb-2");
      contaElement.innerHTML = `
        <p><strong>Número:</strong> ${conta.numero}</p>
        <p><strong>Saldo:</strong> ${conta.saldo.toFixed(2)}</p>
      `;
      accountList.appendChild(contaElement);
    });
  } catch(err) {
    console.error("Erro ao listarcontas", err);
    accountList.innerHTML = "<p>Erro ao carregar as contas. Tente novamente mais tarde.</p>";
  }
}

const cadastrarConta = async (numero, saldo) => {
  try {
    const response = await fetch(baseURL, {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      body: new URLSearchParams({ numero, saldo })
    });

    if(!response.ok) {
      throw new Error(`Erro na requisição: ${response.statusText}`);
    }

    const data = await response.text(); 
    console.log(data);
    return true;
  } catch(err) {
    console.error("Erro ao cadastrar conta", err);
    return false;
  }
}

// Eventos
listButton.addEventListener("click", listarContas);

form.addEventListener('submit', function(event) {
  event.preventDefault(); // Evita o envio padrão do formulário

  // Captura os valores dos inputs
  const createConta = document.getElementById('createConta').value;
  const initSaldo = document.getElementById('initSaldo').value;

  const response = cadastrarConta(createConta, initSaldo);

  if(response) {
    alert(`Conta criada!\n\nNome: ${createConta}\nSaldo Inicial: ${initSaldo}`);
    listarContas();
  } else {
    alert("Algo deu errado tente novamente mais tarde");
  }
  
});


