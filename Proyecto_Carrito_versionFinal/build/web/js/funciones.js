/* 
 * en este documento de java script, haremos los codigos para la opcion eliminar del detalle de compras
 * en primera parte y para la opcion de sumar la cantidad de items en la planilla de detalle de compras
 * evitando asi que se dupliquen los items en la lista final
 */
$(document).ready(function (){
    $("tr #btnDelete").click(function (){
        var idp=$(this).parent().find("#idp").val();
        swal({
            title: "Esta seguro de Eliminar?",
            text: "Si lo desea Usted puede agregarlo de nuevo!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }) .then((willDelete) => {              
            if (willDelete) {
                eliminar(idp);
                swal("El item ha sido eliminado de su lista de compras!", {
                icon: "success",
            }).then((willDelete)=>{
                if(willDelete){
                    parent.location.href="Controlador?accion=Carrito";
                }
            });
            } else {
                 swal("Registro no eliminado!");
            }
            }); 
       
    });
    function eliminar (idp){
        var url="Controlador?accion=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR){
                
                          
            }
        });
    }
    
    $("tr #Cantidad").click(function () {
        var idp=$(this).parent().find("#idpro").val();
        var cantidad=$(this).parent().find("#Cantidad").val();
        var url="Controlador?accion=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+idp+"&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href="Controlador?accion=Carrito";    
            }
        });
    });
});
