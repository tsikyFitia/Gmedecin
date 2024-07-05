function editMedecin(button) {
    const id = $(button).data('id');
    const nom = $(button).data('nom');
    const prenom = $(button).data('prenom');

    $('#medecinForm').attr('action', '/admin/medecin/' + id);
    $('#id').val(id);
    $('#nom').val(nom);
    $('#prenom').val(prenom);
    $('#formTitle').text('Modifier Médecin');
    $('#submitBtn').text('Modifier');
    $('#medecinFormModal').show();
}

function deleteMedecin(id) {
    $.ajax({
        url: '/admin/medecin/' + id,
        type: 'DELETE',
        success: function(result) {
            window.location.reload();
        }
    });
}

function openForm() {
    $('#medecinForm').attr('action', '/admin/medecin/');
    $('#id').val('');
    $('#nom').val('');
    $('#prenom').val('');
    $('#formTitle').text('Ajouter Médecin');
    $('#submitBtn').text('Ajouter');
    $('#medecinFormModal').show();
}

function closeForm() {
    $('#medecinFormModal').hide();
}