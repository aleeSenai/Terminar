document.getElementById('login-form').innerHTML = `
    <input type="email" id="email" name="email" placeholder="Email" required class="w-full p-2 border rounded" />
    <input type="password" id="senha" name="senha" placeholder="Senha" required class="w-full p-2 border rounded" />
    <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded">Entrar</button>
`;

document.getElementById('login-form').addEventListener('submit', async function(e) {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const response = await fetch('/api/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, senha })
    });

    const data = await response.json();
    if (data.success) {
        document.getElementById('login-container').classList.add('hidden');
        document.getElementById('nota-container').classList.remove('hidden');
    } else {
        alert('Erro ao logar!');
    }
});