 document.addEventListener('DOMContentLoaded', function() {
        var planifierRVBtns = document.querySelectorAll('.planifierRVBtn');

        planifierRVBtns.forEach(function(btn) {
            btn.addEventListener('click', function() {
                var creneauId = this.getAttribute('data-creneau-id');
                document.getElementById('creneauId').value = creneauId;
                document.getElementById('rvFormModal').style.display = "block";
            });
        });

        // Récupérer le bouton de fermeture et attacher un événement pour le fermer
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function() {
            document.getElementById('rvFormModal').style.display = "none";
        }

        // Fermer le pop-up lorsque l'utilisateur clique en dehors du contenu
        window.onclick = function(event) {
            var modal = document.getElementById('rvFormModal');
            if (event.target == modal) {
                modal.style.display = "none";
            }
        };
    });

            function submitRVForm() {
                // Récupérer les données du formulaire
                var creneauId = $('#creneauId').val(); // Utilisez # pour sélectionner par ID avec jQuery
                var idClient = $('#idClient').val();
                var jour = $('#jour').val();

                // Construire l'objet data
                var data = {
                    idClient: idClient,
                    idCreneau: creneauId,
                    jour: jour
                };

                // Effectuer la requête AJAX
                $.ajax({
                    url: '/client/rv', // URL de votre endpoint
                    type: 'POST',
                    contentType: 'application/json', // Spécifiez le type de contenu
                    data: JSON.stringify(data), // Convertissez l'objet en chaîne JSON
                    success: function(response) {
                        // Gérer le succès
                        alert('Réservation validée avec succès!');
                        // Actualiser la page ou effectuer d'autres actions ici
                        location.reload(); // Actualiser la page
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        // Gérer l'erreur
                        alert('Erreur lors de la réservation.');
                    }
                });

                // Fermer le pop-up après soumission
                $('#rvFormModal').hide(); // Utilisez modal('hide') si vous utilisez Bootstrap Modal
            }
    //}