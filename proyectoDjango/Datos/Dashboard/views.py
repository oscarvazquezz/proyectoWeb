from django.shortcuts import render
from django.views.generic import View
# Create your views here.
from django.contrib.auth.mixins import LoginRequiredMixin

class DashboardClass(LoginRequiredMixin,View):
    def  get(self,request,*args,**kwargs):
        return render(request,'Dashboard/Dashbord.html')  