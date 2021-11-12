/****** Script for SelectTopNRows command from SSMS  ******/
select * from Coberturas

alter table Detalles_Factura
alter column precioVenta float not null

select * from Articulos where idArticulo = 1

select * from Facturas
insert into Facturas values (1,2,1,1)

select * from Detalles_Factura
select c.idCliente,c.nombre,co.idObraSocial,os.nombre,co.idArticulo,co.descuento ,a.precio
from Clientes c join Obras_Sociales os on c.idObraSocial = os.idObraSocial join Coberturas co on co.idObraSocial = os.idObraSocial join Articulos a on a.idArticulo = co.idArticulo

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

