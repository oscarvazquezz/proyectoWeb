from django.shortcuts import render
from django.views.generic import View
from django.shortcuts import redirect
from django.contrib.auth import authenticate
from django.contrib.auth import login as login_django
#style="background-color:#B264FE"

class LoginClass(View):
    template = 'Login/Login.html'
    landingVista = 'Landing/Landing.html'
    def get(self,request,*args,**kwargs):
        if request.user.is_authenticated:
            next_url = request.GET.get('next') 
            if next_url:
                return redirect(next_url)
            else:
                return redirect('Dashboard:Dashboard')
        return render(request,self.template,{})
    
    def post(self,request,*args,**kwargs):
        email = request.POST['user']
        password = request.POST['password']
        userSesion = authenticate(username = email, password = password)

        if userSesion is not None:
            login_django(
                request,userSesion
            )
            next_url = request.GET.get('next') 
            if next_url:
                return redirect(next_url)
            else:
                return redirect('Dashboard:Dashboard')

        else:
            self.messege = 'verifica tu usuario o tu contraseña'
            
        return render(request,self.template,self.get_context())
    
    def get_context(self):
        return{
            'error':self.messege
        }
    

