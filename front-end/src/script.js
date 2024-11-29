const form = document.getElementById("accountForm");

form.addEventListener('submit', function(event) {
  event.preventDefault(); // Evita o envio padrão do formulário

  // Captura os valores dos inputs
  const createConta = document.getElementById('createConta').value;
  const initSaldo = document.getElementById('initSaldo').value;

  alert(`Conta criada!\n\nNome: ${createConta}\nSaldo Inicial: ${initSaldo}`);
});