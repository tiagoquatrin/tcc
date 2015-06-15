function ajaxCall(url, postData, async, success) {
	$.ajax({
		url: url,
		type: 'POST',
		dataType: 'json',
		data: postData,
		async: async,
		success: function (data) {
			if (data.Result == "OK")
				success(data.data);
			else
				alert(data.message);
		},
		error: function () {
			alert("Erro ao conectar com o servidor");
		}
	});
}

function ajaxCallNoError (url, postData, async, success) {
	$.ajax({
		url: url,
		type: 'POST',
		dataType: 'json',
		data: postData,
		async: async,
		success: function (data) {
			if (data.Result == "OK")
				success(data.data);
		},
		error: function () {
		}
	});
}

function capturaMunicipios(controleEstado, controleMunicipio, selecionado) 
{
	ajaxCall("/common/listaMunicipios.do", "estado=" + $("#" + controleEstado).val(), true, function(data) {
		s = "";			
		$(data).each(function() { s = s + "<option value=\"" + this + "\">" + this + "</option>"; });
		$('#' + controleMunicipio).html(s);
		$('#' + controleMunicipio).val(selecionado);
		$('#' + controleMunicipio).trigger('change');
	});
}
function alerta1()
              {
              if(document.querySelector('#k').value!=='') {
                                                alert("Bolsa cadastrada com sucesso!!");
                                                            }
                                                            return false;
                                                        }
                                                        
 document.querySelector=('#form-busca').onsubmit = alerta1;