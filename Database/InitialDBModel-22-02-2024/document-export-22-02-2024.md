# Diagram BD

gems [icon: gem] {
  id string pk
  description string
}

jewel [icon: sun] {
  id string pk
  name string
  description string
  image string
  stock int
  value double
  idcategory string fk
  idmaterial string fk
}

//Seria llave compuesta entre idgema e idjoya
gemxjewel[icon: ruby]{
  id string pk 
  idgem string fk
  idjewel string fk
  quantity int
}

category[icon: crate]{
  id string pk
  name string
}

jeweldimens[icon: split]{
id string pk
idjewel string fk
dimensions string
}

material[icon: d365-customer-service-insights]{
  id string pk
  description string 
}

services[icon:azure-service-providers]{
  id string pk
  title string
  description string
  icon string
  image string
}

ubication[icon: satellite]{
  id string pk
  description string
}

gemxjewel.idgem - gems.id
gemxjewel.idjewel - jewel.id
jewel.idcategory - category.id
jeweldimens.idjewel > jewel.id
jewel.idmaterial - material.id



