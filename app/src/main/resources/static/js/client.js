function editClient(button) {
    const id = $(button).data('id');
    const nom = $(button).data('nom');
    const prenom = $(button).data('prenom');

    $('#clientForm').attr('action', '/admin/client/' + id);
    $('#id').val(id);
    $('#nom').val(nom);
    $('#prenom').val(prenom);
    $('#formTitle').text('Modifier Client');
    $('#submitBtn').text('Modifier');
    $('#clientFormModal').show();
}

function deleteClient(id) {
    $.ajax({
        url: '/admin/client/' + id,
        type: 'DELETE',
        success: function(result) {
            window.location.reload();
        }
    });
}

function openForm() {
    $('#clientForm').attr('action', '/admin/client/');
    $('#id').val('');
    $('#nom').val('');
    $('#prenom').val('');
    $('#formTitle').text('Ajouter Client');
    $('#submitBtn').text('Ajouter');
    $('#clientFormModal').show();
}

function closeForm() {
    $('#clientFormModal').hide();
}