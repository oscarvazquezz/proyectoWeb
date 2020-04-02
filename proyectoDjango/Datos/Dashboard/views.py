from django.shortcuts import render
from django.views.generic import View
from django.shortcuts import redirect
# Create your views here.
from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.auth import logout

class DashboardClass(LoginRequiredMixin,View):
    def get(self,request,*args,**kwargs):
        return render(request,'Dashboard/Dashbord.html')  

    def post(self, request,*args,**kwargs):
        logout(request)
        return redirect('Login:Login')
