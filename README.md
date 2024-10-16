## Descripción del proyecto
Aplicación Backend para la gestión de un bazar, donde cada venta posee una lista de productos y un cliente asociado.

## Requerimientos
- [x] Realizar CRUD/ABML de productos
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET, POST, DELETE, PUT 
  </li>
  <li>
    <strong>Endpoints</strong>: 
    <ul>
      <li>
        <strong>Creación:</strong> localhost:8080/productos/crear 
      </li>
      <li>
        <strong>Lista completa de productos:</strong> localhost:8080/productos 
      </li>
      <li>
        <strong>Traer un producto en particular:</strong> localhost:8080/productos/{codigoProducto}
      </li>
      <li>
        <strong>Eliminación:</strong> localhost:8080/productos/eliminar/{codigoProducto} 
      </li>
      <li>
        <strong>Edición:</strong> localhost:8080/productos/editar/{codigoProducto}
      </li>
    </ul>
  </li>
</ol>
      
- [x] Realizar CRUD/ABML de clientes
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET, POST, DELETE, PUT 
  </li>
  <li>
    <strong>Endpoints</strong>: 
    <ul>
      <li>
        <strong>Creación:</strong> localhost:8080/clientes/crear
      </li>
      <li>
        <strong>Lista completa de clientes:</strong> localhost:8080/clientes 
      </li>
      <li>
        <strong>Traer un cliente en particular:</strong> localhost:8080/clientes/{idCliente}
      </li>
      <li>
        <strong>Eliminación:</strong> localhost:8080/clientes/eliminar/{idCliente} 
      </li>
      <li>
        <strong>Edición:</strong> localhost:8080/clientes/editar/{idCliente}
      </li>
    </ul>
  </li>
</ol>

- [x] Realizar CRUD/ABML de ventas
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET, POST, DELETE, PUT 
  </li>
  <li>
    <strong>Endpoints</strong>: 
    <ul>
      <li>
        <strong>Creación:</strong> localhost:8080/ventas/crear
      </li>
      <li>
        <strong>Lista completa de ventas:</strong> localhost:8080/ventas 
      </li>
      <li>
        <strong>Traer una venta en particular:</strong> localhost:8080/ventas/{codigoVenta}
      </li>
      <li>
        <strong>Eliminación:</strong> localhost:8080/ventas/eliminar/{codigoVenta} 
      </li>
      <li>
        <strong>Edición:</strong> localhost:8080/ventas/editar/{codigoVenta}
      </li>
    </ul>
  </li>
</ol>

- [x] Obtener todos los productos cuya cantidad_disponible sea menor a un número indicado
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET
  </li>
  <li>
    <strong>Endpoint</strong>: 
    <ul>
      <li>
        localhost:8080/productos/falta_stock/{cantidad}
      </li>
    </ul>
  </li>
</ol>

- [x] Obtener la lista de productos de una determinada venta
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET
  </li>
  <li>
    <strong>Endpoint</strong>: 
    <ul>
      <li>
        localhost:8080/ventas/productos/{codigoVenta}
      </li>
    </ul>
  </li>
</ol>

- [x] Obtener la sumatoria del monto y también la cantidad total de ventas de un determinado día
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET
  </li>
  <li>
    <strong>Endpoint</strong>: 
    <ul>
      <li>
        localhost:8080/ventas/fecha/{fechaVenta}
      </li>
    </ul>
  </li>
</ol>

- [x] Obtener el código de la venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas
<ol>
  <li>
    <strong>Métodos HTTP:</strong> GET
  </li>
  <li>
    <strong>Endpoint</strong>: 
    <ul>
      <li>
        localhost:8080/ventas/mayor_venta
      </li>
    </ul>
  </li>
</ol>

## Documentación de las solicitudes
[Ver solicitudes](https://documenter.getpostman.com/view/13576757/2sAXxV4UbS)

## Herramientas
* Java
* Spring Boot
* JPA
* Hibernate

## Arquitectura
Arquitectura Multicapas
* Capa Controller
* Capa Service
* Capa Repository
* Capa Model
* Capa DTO

</br>

> [!IMPORTANT]
> Crea la bd en MySQL llamada bazar, usa tu servidor de preferencia </br>
> Asegúrate que la base de datos se encuentre totalmente vacía

</br>

![Static Badge](https://img.shields.io/badge/java-white?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=black)
</br>
![sp](https://img.shields.io/badge/SPRING%20BOOT-white?style=for-the-badge&logo=springboot&logoColor=white&labelColor=%236DB33F)
</br>
![h](https://img.shields.io/badge/HIBERNATE-white?style=for-the-badge&logo=hibernate&logoColor=white&labelColor=%23FF2E63)
