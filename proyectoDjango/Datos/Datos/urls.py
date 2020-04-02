
from django.contrib import admin
from django.urls import  include,path,re_path
from Login import views
from Landing import views 
from Dashboard import views
from Registro import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('Login/',include('Login.urls')),
    path('',include('Landing.urls')),
    path('Dashboard/',include('Dashboard.urls')),
    path('Registro/',include('Registro.urls')),
]

