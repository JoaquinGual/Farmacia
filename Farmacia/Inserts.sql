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

insert into Coberturas values(30,1,1)
insert into Coberturas values(60,2,3)
insert into Coberturas values(30,3,1)

--Resetear Identity
delete from Facturas
DBCC CHECKIDENT ('Facturas', RESEED, 0)


select a.idArticulo,a.descripcion,a.precio,a.
from Articulos a join Detalles_Factura df on a.idArticulo = df.idArticulo



select c.idCliente,c.nombre,co.idObraSocial,os.nombre,co.idArticulo,co.descuento ,a.precio
from Clientes c join Obras_Sociales os on c.idObraSocial = os.idObraSocial join Coberturas co on co.idObraSocial = os.idObraSocial join Articulos a on a.idArticulo = co.idArticulo
where idCliente = 1
select * from Coberturas

alter table Detalles_Factura
alter column precioVenta float not null

select * from Articulos where idArticulo = 1

insert into Facturas values (1,2,1,1) --Precio con desucuento arriba


--DTO DETALLE ARTICULO
select df.idArticulo, a.descripcion,df.cantidad, a.precio ,df.descuentoObra, df.precioVenta
from Detalles_Factura df join Articulos a on df.idArticulo = a.idArticulo


--Para consultar los stocks faltantes
select a.descripcion,s.direccion,  a.stockMinimo - a.stockActual  'Stock Faltante'
from Sucursales s join Facturas f on s.idSucursal = f.idSucursal join Detalles_Factura df on df.idFactura = f.idFactura join Articulos a on df.idArticulo = a.idArticulo
where a.stockMinimo > a.stockActual
group by a.descripcion,s.direccion,a.stockMinimo - a.stockActual
order by a.descripcion
---------------------------
--Total de recetas por sucursal, indicando cantidad de recetas, importe total a pagar por el cliente e importe total a facturar a las obras sociales
select s.direccion,count(f.idFactura) 'cantidad de recetas',f.idCliente, sum(df.precioVenta*df.cantidad) 'Importe a pagar', sum(df.descuentoObra) 'Facturar a Obra Social'
from Sucursales s join Facturas f on s.idSucursal = f.idSucursal join Detalles_Factura df on df.idFactura = f.idFactura
group by s.direccion,f.idCliente


--Triger ActualizarStock

create trigger actualizarStock on Detalles_Factura  for insert

as
Declare @idArticulo int
select @idArticulo = inserted.idArticulo from inserted
Declare @cantidad int 
 select @cantidad = inserted.cantidad from inserted

update Articulos
set stockActual = stockActual - @cantidad
where idArticulo = @idArticulo