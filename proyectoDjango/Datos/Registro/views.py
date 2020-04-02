from django.shortcuts import render
from django.views.generic import View
from django.shortcuts import redirect
from django.views.generic.edit import FormView
from Registro.forms import RegistroForm
# Create your views here.

class RegistroClass(FormView):

    direcion = 'Registro/Registro.html'
    def get(self,request,*args,**kwargs):
        formulario = RegistroForm(request.GET or None)
        contexto = {
            'form_get' : formulario
        }
        return render(request,self.direcion,contexto)
    
    def post(self, request,*args,**kwargs):
        form = RegistroForm(request.POST or None)
        if form.is_valid():
            self.object = form.save(commit = False)
            self.object.set_password(self.object.password)
            self.object.save()
        return redirect('Login:Login')