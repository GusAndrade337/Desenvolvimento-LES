const express = require('express');
const axios = require('axios');
const bodyParser = require('body-parser');

const app = express();
const port = 3000; // You can change this port if needed

app.set('view engine', 'ejs');
app.use(express.static('public')); // Create a "public" folder for your static assets
app.use(bodyParser.json());

// index.js
app.get('/', async (req, res) => {
    try {
      // Get the "page" parameter from the URL or default to page 1
      const page = parseInt(req.query.page) || 1;
  
      // Make an API request to your backend (localhost:9000) with the "page" parameter
      const response = await axios.get(`http://localhost:8080/Chamados?size=6&page=${page}`);
  
      // Check if the response contains an array of "content" Chamados
      if (Array.isArray(response.data.content)) {
        // Extract the "content" Chamados and their "name" property
        const contentChamados = response.data.content;
  
        // Calculate the total number of pages based on your data (e.g., response.data.totalPages)
        const totalPages = response.data.totalPages;
  
        // Render the EJS template with the content Chamados and pagination data
        res.render('index', { contentChamados, totalPages });
      } else {
        console.error('Invalid data format:', response.data);
        res.status(500).send('Invalid Data Format');
      }
    } catch (error) {
      console.error('Error fetching data:', error);
      res.status(500).send('Internal Server Error');
    }
  });

  app.get('/chamado/:id', async (req, res) => {
    try {
      const ChamadoId = req.params.id; // Get the Chamado ID from the URL
  
      // Make an API request to your backend with the Chamado ID
      const response = await axios.get(`http://localhost:8080/Chamados/${ChamadoId}`);
  
      // Check if the response contains the Chamado details
      if (response.data) {
        // Extract the Chamado details
        const chamado = response.data;
  
        // Render the Chamado details EJS template
        res.render('detail', { chamado });
      } else {
        console.error('Chamado not found or invalid data format');
        res.status(404).send('chamado not found');
      }
    } catch (error) {
      console.error('Error fetching chamado details:', error);
      res.status(500).send('Internal Server Error');
    }
  });
  
  app.get('/profile', async (req, res) => {
    try {
        res.send('Feature ainda não implementada');

    } catch (error) {
      console.error('Error fetching data:', error);
      res.status(500).send('Internal Server Error');
    }
  }); 

  app.get('/help', async (req, res) => {
    try {
        res.send('Feature ainda não implementada');

    } catch (error) {
      console.error('Error fetching data:', error);
      res.status(500).send('Internal Server Error');
    }
  }); 

  app.get('/criarChamado', (req, res) => {
    res.render('criarChamado');
  });
  // Dummy in-memory data
  let Chamados = [];

  app.post('/Chamado', (req, res) => {
    const newChamado = req.body;
  
    // Assign a unique ID to the new Chamado (you may want to use a library for this)
    newChamado.id = Chamados.length + 1;
  
    Chamados.push(newChamado);
  
    res.json(newChamado);
  });
  
  app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
  });


