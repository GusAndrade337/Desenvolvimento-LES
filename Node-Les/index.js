const express = require('express');
const axios = require('axios');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.set('view engine', 'ejs');
app.use(express.static('public')); 
app.use(bodyParser.json());

app.get('/', async (req, res) => {
    try {
      const page = parseInt(req.query.page) || 1;
  
      const response = await axios.get(`http://localhost:8080/Chamados?size=6&page=${page}`);
  
      if (Array.isArray(response.data.content)) {
        const contentChamados = response.data.content;
  
        const totalPages = response.data.totalPages;
  
        res.render('index', { contentChamados, totalPages });
      } else {
        console.error('Formato de dados invalidos:', response.data);
        res.status(500).send('Invalid Data Format');
      }
    } catch (error) {
      console.error('Erro ao conversar com o backend:', error);
      res.status(500).send('Internal Server Error');
    }
  });

  app.get('/chamado/:id', async (req, res) => {
    try {
      const ChamadoId = req.params.id; 
      const response = await axios.get(`http://localhost:8080/Chamados/${ChamadoId}`);
  
      if (response.data) {
        const chamado = response.data;
  
        res.render('detail', { chamado });
      } else {
        console.error('Chamado not found');
        res.status(404).send('chamado not found');
      }
    } catch (error) {
      console.error('Error ao buscar detalhes do chamado:', error);
      res.status(500).send('Internal Server Error');
    }
  });
  
  app.get('/profile', async (req, res) => {
    try {
        res.send('Feature ainda não implementada');

    } catch (error) {
      console.error('Erro ao conversar com o backend', error);
      res.status(500).send('Internal Server Error');
    }
  }); 

  app.get('/help', async (req, res) => {
    try {
        res.send('Feature ainda não implementada');

    } catch (error) {
      console.error('Erro ao conversar com o backend', error);
      res.status(500).send('Internal Server Error');
    }
  }); 

  app.get('/criarChamado', (req, res) => {
    res.render('criarChamado');
  });
  let Chamados = [];

  app.post('/Chamado', (req, res) => {
    const newChamado = req.body;
  
    newChamado.id = Chamados.length + 1;
  
    Chamados.push(newChamado);
  
    res.json(newChamado);
  });
  
  app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
  });


