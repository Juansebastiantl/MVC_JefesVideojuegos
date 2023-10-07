# API REST SKILLS

# CRUD en Springboot y MongoDB para skills

- Crear skill
- Obtener todas las skills
- Obtener una skill por su ID
- Obtener skills por su tipo
- Actualizar una skill
- Borrar una skill por su ID
- Borrar todas las skills

## 3- Código en RAML

```bash

types:
  Skills:
    properties:
      id: string
      nombre: string
      tipo: string
      dificultad: number

```