# frozen_string_literal: true

source "https://rubygems.org"

git_source(:github) { |repo| "https://github.com/#{repo}.git" }

gemspec

# We need a newish Rake since Active Job sets its test tasks' descriptions.
gem "rake", ">= 11.1"

gem "capybara", ">= 3.26"
gem "selenium-webdriver", ">= 3.141.592"

gem "rack-cache", "~> 1.2"
gem "sass-rails"
gem "turbolinks", "~> 5"
gem "webpacker", "~> 4.0", require: ENV["SKIP_REQUIRE_WEBPACKER"] != "true"
# require: false so bcrypt is loaded only when has_secure_password is used.
# This is to avoid Active Model (and by extension the entire framework)
# being dependent on a binary library.
gem "bcrypt", "~> 3.1.11", require: false

# This needs to be with require false to avoid it being automatically loaded by
# sprockets.
gem "uglifier", ">= 1.3.0", require: false

# Explicitly avoid 1.x that doesn't support Ruby 2.4+
gem "json", ">= 2.0.0"

gem "rubocop", ">= 0.47", require: false
gem "rubocop-performance", require: false
gem "rubocop-rails", require: false

group :doc do
  gem "sdoc", "~> 1.0"
  gem "redcarpet", "~> 3.2.3", platforms: :ruby
  gem "w3c_validators"
  gem "kindlerb", "~> 1.2.0"
end

# Active Support
gem "dalli"
gem "listen", "~> 3.2", require: false
gem "libxml-ruby", platforms: :ruby
gem "connection_pool", require: false

# for railties app_generator_test
gem "bootsnap", ">= 1.4.4", require: false

# Gems that are necessary for Active Record tests with Oracle.
if ENV["ORACLE_ENHANCED"]
  platforms :ruby do
    gem "ruby-oci8", "~> 2.2"
  end
  gem "activerecord-oracle_enhanced-adapter", github: "rsim/oracle-enhanced", branch: "master"
end

# A gem necessary for Active Record tests with IBM DB.
gem "ibm_db" if ENV["IBM_DB"]
gem "tzinfo-data", platforms: [:mingw, :mswin, :x64_mingw, :jruby]
gem "wdm", ">= 0.1.0", platforms: [:mingw, :mswin, :x64_mingw, :mswin64]
