from django.urls import include,re_path,path
from django.conf import settings 
from . import views 
#from django contrib.auth import views as auth_views

from Dashboard.views import DashboardClass
  
app_name = 'Dashboard'

urlpatterns = [
    
    path('',DashboardClass.as_view(),name='Dashboard'), 
]