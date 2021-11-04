-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-11-03 04:51:44.225

-- tables
-- Table: Articulos
CREATE TABLE Articulos (
    idArticulo int  NOT NULL IDENTITY(0),
    descripcion varchar(50)  NOT NULL,
    precio float  NOT NULL,
    stockActual int  NOT NULL,
    stockMinimo int  NOT NULL,
    ventaLibre bit  NOT NULL,
    idTipo int  NOT NULL,
    CONSTRAINT Articulos_pk PRIMARY KEY  (idArticulo)
);

-- Table: Clientes
CREATE TABLE Clientes (
    idCliente int  NOT NULL IDENTITY(0),
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    idObraSocial int  NOT NULL,
    CONSTRAINT Clientes_pk PRIMARY KEY  (idCliente)
);

-- Table: Coberturas
CREATE TABLE Coberturas (
    idCobertura int  NOT NULL IDENTITY(0),
    descuento int  NOT NULL,
    idArticulo int  NOT NULL,
    idObraSocial int  NOT NULL,
    CONSTRAINT Coberturas_pk PRIMARY KEY  (idCobertura)
);

-- Table: Detalles_Factura
CREATE TABLE Detalles_Factura (
    idDetalle int  NOT NULL IDENTITY(0),
    cantidad int  NOT NULL,
    idArticulo int  NOT NULL,
    idFactura int  NOT NULL,
    CONSTRAINT Detalles_Factura_pk PRIMARY KEY  (idDetalle)
);

-- Table: Facturas
CREATE TABLE Facturas (
    idFactura int  NOT NULL IDENTITY(0),
    idCliente int  NOT NULL,
    idProfesional int  NOT NULL,
    idMetodo int  NOT NULL,
    idSucursal int  NOT NULL,
    CONSTRAINT Facturas_pk PRIMARY KEY  (idFactura)
);

-- Table: Metodos_Pago
CREATE TABLE Metodos_Pago (
    idMetodo int  NOT NULL IDENTITY(0),
    descripcion varchar(50)  NOT NULL,
    CONSTRAINT Metodos_Pago_pk PRIMARY KEY  (idMetodo)
);

-- Table: Obras_Sociales
CREATE TABLE Obras_Sociales (
    idObraSocial int  NOT NULL IDENTITY(0),
    nombre varchar(50)  NOT NULL,
    CONSTRAINT Obras_Sociales_pk PRIMARY KEY  (idObraSocial)
);

-- Table: Profesionales
CREATE TABLE Profesionales (
    idProfesional int  NOT NULL IDENTITY(0),
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    matricula int  NOT NULL,
    CONSTRAINT Profesionales_pk PRIMARY KEY  (idProfesional)
);

-- Table: Sucursales
CREATE TABLE Sucursales (
    idSucursal int  NOT NULL IDENTITY(0),
    direccion varchar(50)  NOT NULL,
    CONSTRAINT Sucursales_pk PRIMARY KEY  (idSucursal)
);

-- Table: Tipos_Articulos
CREATE TABLE Tipos_Articulos (
    idTipo int  NOT NULL IDENTITY(0),
    descripcion varchar(50)  NOT NULL,
    CONSTRAINT Tipos_Articulos_pk PRIMARY KEY  (idTipo)
);

-- foreign keys
-- Reference: Articulos_Tipo_Articulo (table: Articulos)
ALTER TABLE Articulos ADD CONSTRAINT Articulos_Tipo_Articulo
    FOREIGN KEY (idTipo)
    REFERENCES Tipos_Articulos (idTipo);

-- Reference: Cliente_Obras_Sociales (table: Clientes)
ALTER TABLE Clientes ADD CONSTRAINT Cliente_Obras_Sociales
    FOREIGN KEY (idObraSocial)
    REFERENCES Obras_Sociales (idObraSocial);

-- Reference: Coberturas_Articulos (table: Coberturas)
ALTER TABLE Coberturas ADD CONSTRAINT Coberturas_Articulos
    FOREIGN KEY (idArticulo)
    REFERENCES Articulos (idArticulo);

-- Reference: Coberturas_Obras_Sociales (table: Coberturas)
ALTER TABLE Coberturas ADD CONSTRAINT Coberturas_Obras_Sociales
    FOREIGN KEY (idObraSocial)
    REFERENCES Obras_Sociales (idObraSocial);

-- Reference: Detalle_Factura_Articulos (table: Detalles_Factura)
ALTER TABLE Detalles_Factura ADD CONSTRAINT Detalle_Factura_Articulos
    FOREIGN KEY (idArticulo)
    REFERENCES Articulos (idArticulo);

-- Reference: Detalle_Factura_Facturas (table: Detalles_Factura)
ALTER TABLE Detalles_Factura ADD CONSTRAINT Detalle_Factura_Facturas
    FOREIGN KEY (idFactura)
    REFERENCES Facturas (idFactura);

-- Reference: Facturas_Cliente (table: Facturas)
ALTER TABLE Facturas ADD CONSTRAINT Facturas_Cliente
    FOREIGN KEY (idCliente)
    REFERENCES Clientes (idCliente);

-- Reference: Facturas_Metodo_Pago (table: Facturas)
ALTER TABLE Facturas ADD CONSTRAINT Facturas_Metodo_Pago
    FOREIGN KEY (idMetodo)
    REFERENCES Metodos_Pago (idMetodo);

-- Reference: Facturas_Profesionales (table: Facturas)
ALTER TABLE Facturas ADD CONSTRAINT Facturas_Profesionales
    FOREIGN KEY (idProfesional)
    REFERENCES Profesionales (idProfesional);

-- Reference: Facturas_Sucursal (table: Facturas)
ALTER TABLE Facturas ADD CONSTRAINT Facturas_Sucursal
    FOREIGN KEY (idSucursal)
    REFERENCES Sucursales (idSucursal);

-- End of file.

