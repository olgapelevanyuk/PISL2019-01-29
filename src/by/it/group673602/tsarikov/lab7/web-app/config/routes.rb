Rails.application.routes.draw do
  root 'users#index', as: 'home'

  get 'about' => 'pages#about', as: 'about'

  resources :users
end
