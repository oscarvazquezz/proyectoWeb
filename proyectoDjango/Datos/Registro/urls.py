from django.urls import include,re_path,path
from django.conf import settings 
from . import views 
#from django contrib.auth import views as auth_views

from Registro.views import RegistroClass
  
app_name = 'Registro'

urlpatterns = [
    
    path('',RegistroClass.as_view(),name='Registro'), 
]