<p align="center">

![FSA](app/src/main/res/drawable/logo_fsa.png)

</p>

<div align="center">
<h1 style="font-weight: bold;">CalendarFSA - Aplicativo Acadêmico para Organização e Gestão de Aulas💻</h1>

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Gradle Plugin](https://img.shields.io/badge/AGP-8.6.0-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Android Core KTX](https://img.shields.io/badge/Core%20KTX-1.10.1-4285F4?style=for-the-badge&logo=android&logoColor=white)
![AppCompat](https://img.shields.io/badge/AppCompat-1.7.0-0D47A1?style=for-the-badge&logo=android&logoColor=white)

</div>

<div align="center">

![Android Gradle Plugin](https://img.shields.io/badge/AGP-8.6.0-brightgreen)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-purple)
![Android Core KTX](https://img.shields.io/badge/Core%20KTX-1.10.1-blue)
![JUnit](https://img.shields.io/badge/JUnit-4.13.2-red)
![JUnit Android](https://img.shields.io/badge/JUnit%20(Android)-1.1.5-orange)
![Espresso](https://img.shields.io/badge/Espresso-3.5.1-brightgreen)
![Lifecycle Runtime KTX](https://img.shields.io/badge/Lifecycle%20Runtime%20KTX-2.6.1-blueviolet)
![Activity Compose](https://img.shields.io/badge/Activity%20Compose-1.8.0-lightgrey)
![Compose BOM](https://img.shields.io/badge/Compose%20BOM-2024.04.01-yellow)
![AppCompat](https://img.shields.io/badge/AppCompat-1.7.0-darkblue)
![RecyclerView](https://img.shields.io/badge/RecyclerView-1.3.2-green)
![Room KTX](https://img.shields.io/badge/Room%20KTX-2.6.1-orange)

</div>





<p align="center">

  • [Introdução](#introdução) • [Descrição](#descrição) •  [Funcionalidades](#funcionalidades) • [Instalação](#instalação) • [Como Usar](#como-usar) • [Estrutura do Código](#estrutura-do-código) • [Exemplo de Uso](#exemplo-de-uso) • [Dependências](#dependências) • [Instalação das dependências](#instalação-das-dependências) • [Conclusões](#conclusões) • [Sobre o Autor](#autor)

</p>

# CalendarFSA

## Introdução

CalendarFSA é uma aplicação Android desenvolvida como parte de uma atividade acadêmica para aprender e praticar o uso de tecnologias como Android Studio, Kotlin e SQLite. O projeto visa proporcionar uma compreensão prática da criação de aplicativos móveis, com foco em autenticação de usuário, manipulação de banco de dados local e navegação entre diferentes atividades e fragmentos. A aplicação permite que os usuários organizem suas atividades acadêmicas, incluindo o acesso ao calendário de aulas e perfil de usuário.

## Descrição

A aplicação CalendarFSA visa simplificar o gerenciamento das atividades diárias e dos cursos oferecidos ao usuário. O app é projetado para ser intuitivo, com uma interface amigável, facilitando o acesso rápido a informações importantes, como calendário de aulas, cursos disponíveis e informações de perfil.

## Funcionalidades

- **Login e Cadastro de Usuário**: Permite que os usuários façam login e cadastro.
- **Recuperação de Senha**: Opção para redefinir a senha por meio de e-mail.
- **Visualização de Aulas Diárias**: Mostra as aulas planejadas para o dia atual.
- **Cursos do Semestre**: Exibe uma lista dos cursos oferecidos.
- **Perfil do Usuário**: Exibe e permite a edição de informações do perfil do usuário (nome, telefone, e-mail).
- **Fragmento de Logo**: Presente em várias telas, fornece uma identidade visual coesa à aplicação.

## Instalação

1. Clone o repositório em sua máquina local:
```
git clone https://github.com/KelvenVS/CalendarFSA.git
```
2. Abra o projeto no Android Studio.
3. Conecte um dispositivo Android ou use um emulador Android.
4. Compile e execute a aplicação.

## Como Usar

1. **Login e Cadastro**: Ao abrir o aplicativo pela primeira vez, você será direcionado para a tela de login. Caso não tenha uma conta, você pode se registrar.
2. **Recuperação de Senha**: Se esquecer a senha, clique em "Esqueci minha senha" para redefini-la.
3. **Acessar Aulas Diárias**: Após o login, a tela de aulas diárias estará acessível. Nela, você pode ver a programação do dia.
4. **Visualizar Cursos do Semestre**: Acesse a seção de cursos para ver uma lista dos cursos do semestre.
5. **Editar Perfil**: Vá até o perfil para visualizar e atualizar suas informações de usuário.

## Estrutura do Código

A aplicação é organizada nas seguintes atividades e classes principais:

- `LoginActivity`: Gerencia o login e navegações iniciais.
- `PasswordRecoveryActivity`: Tela para recuperação de senha.
- `RegistrationActivity`: Tela de cadastro de usuário, com validação e armazenamento local.
- `DailyClassesActivity`: Exibe as aulas diárias do usuário.
- `SemesterCoursesActivity`: Lista dos cursos do semestre.
- `UserProfileActivity`: Tela de perfil onde o usuário pode visualizar e editar suas informações.
- `LogoFragment`: Fragmento de logo, compartilhado em várias telas para consistência visual.

## Exemplo de Uso

1. **Login**: Ao abrir o aplicativo, faça login com seu nome de usuário e senha.
2. **Navegação**: Use os botões para navegar entre as seções (Perfil, Aulas Diárias, etc.).
3. **Editar Perfil**: No perfil, altere as informações e clique em "Salvar" para atualizar.
4. **Recuperação de Senha**: Insira seu e-mail e uma nova senha, e clique em "Recuperar Senha" para redefini-la.

## Dependências

- **SQLite**: Banco de dados local para armazenar informações do usuário.
- **AndroidX**: Conjunto de bibliotecas de suporte para melhorar a compatibilidade entre versões.
- **Kotlin**: Linguagem de programação principal utilizada para o desenvolvimento.
- **Fragments**: Utilizados para modularizar o layout, tornando o aplicativo mais flexível e reutilizável.

## Instalação das Dependências

- As dependências serão instaladas automaticamente ao abrir o projeto no Android Studio. Certifique-se de estar conectado à internet e sincronize o projeto com o Gradle para instalar todas as dependências.


## Conclusões

Desenvolver o CalendarFSA foi uma experiência extremamente valiosa para mim, pois me permitiu colocar em prática os conceitos de Programação de Dispositivos Móveis que venho aprendendo. Trabalhar com Android e Kotlin me deu uma visão mais clara das particularidades e desafios do desenvolvimento mobile, como o gerenciamento de atividades, navegação entre telas, e a importância de uma interface de usuário amigável. Além disso, explorar o uso do SQLite para armazenamento local foi essencial para entender como os dados podem ser geridos de forma eficiente em um aplicativo.

Usar o Android Studio e integrar componentes como Fragments e RecyclerView foi uma experiência que me mostrou como é possível construir uma interface modular e adaptável, enquanto o Room KTX e outras bibliotecas AndroidX facilitaram o armazenamento e recuperação dos dados do usuário. Esses conhecimentos são fundamentais para garantir que o aplicativo seja escalável e de fácil manutenção.

A organização do código e a estrutura do projeto também foram um aprendizado importante. Saber como dividir e estruturar funcionalidades ajuda muito a manter o código limpo e pronto para futuras melhorias. No final, vejo que o CalendarFSA não só atinge os objetivos da atividade, mas também me preparou melhor para desenvolver aplicativos mais complexos e robustos no futuro, seja em outros projetos acadêmicos ou profissionais.

## Autor

*Este projeto foi desenvolvido por **Kelven Vilela Serejo**, aluno do **8º semestre de Engenharia da Computação** na **Fundação Santo André**, como parte da **Atividade** da disciplina **Programação de Dispositivos Móveis**, ministrada pelo professor **Felipe Desiglo Ferrare**.*
