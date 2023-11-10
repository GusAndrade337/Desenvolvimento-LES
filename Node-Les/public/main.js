document.addEventListener('DOMContentLoaded', function() {
    const addChamadoForm = document.getElementById('addChamadoForm');
  
    addChamadoForm.addEventListener('submit', function(event) {
      event.preventDefault();
  
      const formData = new FormData(addChamadoForm);
  
      const formDataObject = {};
      formData.forEach((value, key) => {
        formDataObject[key] = value;
      });
  
      fetch('http://localhost:8080/Chamados', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formDataObject),
      })
      .then(response => response.json())
      .then(data => {
        console.log('Chamado added successfully:', data);
      })
      .catch(error => {
        console.error('Error adding Chamado:', error);
      });
    });
  });
  