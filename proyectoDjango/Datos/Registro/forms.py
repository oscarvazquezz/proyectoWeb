from django.contrib.auth.models import User
from django import forms

ERROR_MESSAGE_USER = {'unique' : 'El Username ya se encuentra registrado', 'invalid' : 'usuario o contraseña incorrecto'}
ERROR_MESSAGE_PASSWORD = {'required' : 'El password es requerido'}
ERROR_MESSAGE_EMAIL = {'invalid' : 'Ingrese un correo valido'}
ERROR_MESSAGE_PHONE = {'invalid' : 'Formato numero incorrecto'}


class RegistroForm(forms.ModelForm):
    first_name = forms.CharField(label='', required=True)
    last_name = forms.CharField(label='', required=True)
    password = forms.CharField(max_length = 20,required=True, widget = forms.PasswordInput(), error_messages = ERROR_MESSAGE_PASSWORD )
    email = forms.CharField( required = True, error_messages = ERROR_MESSAGE_EMAIL)

    def __init__(self, *args, **kwargs):
        super(RegistroForm, self).__init__(*args, **kwargs)
        self.fields['username'].widget.attrs.update( {'id': 'userCreate', 'class': 'form-control', 'placeholder': 'Usuario'} )
        self.fields['first_name'].widget.attrs.update( {'id': 'first', 'class': 'form-control', 'placeholder': 'Nombre'} )
        self.fields['last_name'].widget.attrs.update( {'id': 'lastName', 'class': 'form-control', 'placeholder': 'Apellidos'} )
        self.fields['password'].widget.attrs.update( {'id': 'password', 'class': 'form-control', 'placeholder': 'Contraseña'} )
        self.fields['email'].widget.attrs.update( {'id': 'email', 'class': 'form-control', 'placeholder': 'Correo Electrónico'} )
    
    class Meta:
        model = User
        fields = ['username', 'email', 'first_name', 'last_name', 'password']