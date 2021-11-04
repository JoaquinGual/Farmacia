insert into Sucursales values ('Central')
insert into Sucursales values ('Ruta 20')

insert into Metodos_Pago values('Efectivo')
insert into Metodos_Pago values('Tarjeta de Credito')
insert into Metodos_Pago values('Combinado')

insert into Profesionales values ('Alan','Monteiro',111)
insert into Profesionales values ('Augusto','Albarracin',222)
insert into Profesionales values ('Joaquin','Gual',333)

insert into Obras_Sociales values('GEA')
insert into Obras_Sociales values('APROSS')
insert into Obras_Sociales values('OSDE')

insert into Clientes values ('Juan','Lopez',1)
insert into Clientes values ('Valentin','Cequeira',3)
insert into Clientes values ('Martin','Ramirez',2)

insert into Tipos_Articulos values('Jarabes')
insert into Tipos_Articulos values('Comprimidos')
insert into Tipos_Articulos values('Inyectables')

insert into Articulos values ('Paracetamol',150,15,3,1,2)
insert into Articulos values ('Ibuprofeno',200,30,5,1,2)
insert into Articulos values ('Kodeina',1000,0,1,0,1)
insert into Articulos values ('Decadron',300,2,3,1,3)



--Resetear Identity
DBCC CHECKIDENT ('Clientes', RESEED, 0)